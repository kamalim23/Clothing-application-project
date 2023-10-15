import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
  



export function Desworkpage() {
  
 
    var { s_no } = useParams()
    console.log(s_no)

    function handleregister(event) {
        event.preventDefault()

        var productName = document.getElementById("product_name").value

        var productDescription = document.getElementById("product_description").value

        var productImage = document.getElementById("product_image").value

        var productRate = document.getElementById("product_price").value

        var designerDescription = document.getElementById("designer_description").value
        
        var designerName = document.getElementById("designer_name").value

        var desdetails = {
            productName: productName,
            productDescription: productDescription,
            productImage: productImage,
            productRate: productRate,
            designerDescription: designerDescription,
            designerName: designerName

        }
        if (productName === "" && productDescription === "" && productImage === "" && productRate === "" && designerDescription === "" &&   designerName==="") {
            alert("please enter the feilds")
        }
        else {
            axios.post("http://localhost:8080/product/createProduct/"+ s_no,{"productName":productName,"productDescription":productDescription,"productRate":productRate,"productImage":productImage,"designerName":designerName,"designerDescription":designerDescription})
                .then(res => {
                   console.log(res)
                    if (res.data.data === "uploaded failed") {
                         alert("uploaded failed")
                    }
                    else if (res.data.data === "uploaded successfully") {
                        alert("uploaded Successfully !")
                        window.location.href=`/desviewpage/${s_no}`
                    }

                })

        }

    }
    return (
        <>
            <div className=" py-2 container-fluid">

                <div className="deswork-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">

                    <h1 className=" text-center sigreg  despro">Enter Your Works</h1>
                    <form onSubmit={handleregister}>
                        <table className="mt-5">
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Name</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_name"  /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Description</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_description" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Image</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_image"  /></td>
                            </tr>

                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Price</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_price"  /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Desiger Description</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text " id="designer_description"/></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Desiger Name</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text " id="designer_name"/></td>
                            </tr>
                        </table>
                        <div className="text-center m-3 btsig">
                              <button className ="btn2"type="submit">Submit</button>
                        </div>
                    </form>

                </div>
            </div>
        </>
    );
}