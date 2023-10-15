import React from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
export function Customerform(){
     var { s_no } = useParams()
     console.log( s_no)
    function handleregister(event){
        event.preventDefault()
        var customerName = document.getElementById("cus_name").value;
        var registerMobileNumber = document.getElementById("mobile_number").value;
        var customerLocation = document.getElementById("cus_locstion").value;
        var dressModel = document.getElementById("dress_model").value;
        var descriptionAboutDress = document.getElementById("dress_description").value;
    
        var orderdetails={
            sNo:s_no,
            customerName:customerName,
            registerMobileNumber:registerMobileNumber,
            customerLocation:customerLocation,
            dressModel:dressModel,
            descriptionAboutDress:descriptionAboutDress,
           
        }
    if(customerName==="" &&registerMobileNumber===""&&customerLocation===""&&dressModel===""&&descriptionAboutDress===""){
        alert("Enter the feileds")
    }
    
     else {
        axios.post("http://localhost:8080/order/insertorder/"+s_no,orderdetails)
            .then(res => {
           
                if (res.data.data === "Failed to placed") {
                    alert("Failed to order !")

                }
                else if (res.data.data === "Order placed  successfully") {
                    alert("Successfully orderplaced !")
                 
              }
             })
    }  
   }
    return(
     <>
            <div className="signup-bg py-2 container-fluid ">
           
                <div className="sigcard-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">
                    <form onSubmit={handleregister}>
                   
                    <h1 className=" text-center sigreg ">Information Form</h1>
                   
                    <table className="mt-5">
                        <tr>
                            <th className="sigtxt col-lg-3 text-primary " >Customer Name</th>
                            <td><input className="w-120 siginp" type="text"  id="cus_name"/></td>
                        </tr>
                        <tr>
                            <th className="sigtxt text-primary">Customer Register mobile number</th>
                            <td><input className="w-120 siginp" type="text"  id="mobile_number" /></td>
                        </tr>
                        <tr>
                            <th className="sigtxt text-primary"> Customer Location</th>
                            <td><input className="w-120 siginp" type="text"   id="cus_locstion"/></td>
                        </tr>
                       
                        <tr>
                            <th className="sigtxt text-primary" >Dress Model</th>
                            <td><input className="w-120 siginp" type="text"  id="dress_model"/></td>
                        </tr>
                        <tr>
                            <th className="sigtxt text-primary">Description about the dress</th>
                            <td><input className="w-120 siginp" type="text"  id="dress_description" /></td>
                        </tr>
                    </table>
                    <div className="text-center m-3 btsig">
                        <button  className="btn2   siglog" type="submit">SUBMIT</button>
                    </div>
                    </form>
                </div>
            </div>
         </>
)}
       
  
