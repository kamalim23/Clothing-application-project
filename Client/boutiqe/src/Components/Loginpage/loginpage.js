import axios from "axios";
import React from "react";
import { Link, useParams } from "react-router-dom";
export function Loginpage() {
  var {sNo} = useParams()
  function handlelogin(event){
    event.preventDefault()
   var email = document.getElementById("email").value
  var password = document.getElementById("password").value

  let Logindetails = {
    email:  email,
    password : password
  }
  if (email === "") {
    alert("enter your email")
  }
  else if (password ==="") {
    alert("enter your password")
  }
  else {
    axios.post("http://localhost:8080/auth/loginpage", Logindetails)
      .then((res) => {
        console.log(res)
        if (res.data.data === "Designer"){
          alert("Designer login succesfully !")
           window.location.href=`/desuppage/${res.data.jData.sNo}`
       
        }
        else if (res.data.data === "Customer") {
          alert("customer login successfully !")
          window.location.href=`/cusviewpage/${res.data.jData.sNo}`
        }
        else if(res.data.setData ==="User Does Not Exist!"){
           alert("dosn't exixt ! ")

        }
        else {
          alert("invalid datas !")
        }

      })
    }
  }
  return (

    <>
      <div className="card logbg image-fluid mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container" >
        <div className=" align-items-center">
        <form onSubmit={handlelogin}>
          <h1 className="col-lg-12   d-flex justify-content-center container   logfrm   sigreg">Login Form</h1>
          <table className="m-5">
            <section className="logsec">
              <tr className="logtxt">
                  <th className=" " >Email</th>
                  <td><input className="w-90 loginp" type="email" id="email" recquired placeholder="Enter your email" /></td>
              </tr>
              <tr>
                <th className="col-lg-3"  >Password</th>
                <td> <input className="w-90 loginp " type="password" id="password"  placeholder="Enter your password"/></td>
              </tr>
            </section>
          </table>
          <div className="text-center m-3 btsig">
            <Link to='/Signuppage' className="btn  me-5  mb-4  logbt"><button className="sinbtn">SIGNUP</button></Link>
            <button className="  btn3  siglog ms-1  logbt " type="submit" >DONE</button>
          </div>
          </form>
      </div>
    </div >
    </>
  );
}