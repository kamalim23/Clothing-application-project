import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";
export function Signuppage() {
    function handleregister(event) {
        event.preventDefault()
        var firstName = document.getElementById("first_name").value
        var lastName = document.getElementById("last_name").value
        var age = document.getElementById("age").value
        var email = document.getElementById("email").value
        var password = document.getElementById("password").value
        var phoneNumber = document.getElementById("phone_number").value
        var location = document.getElementById("location").value
        var isDesigner = document.getElementById("isDesigner").value
        var regdetails = {
            firstName: firstName,
            lastName: lastName,
            age: age,
            email: email,
            password: password,
            phoneNumber: phoneNumber,
            location: location,
            isDesigner: isDesigner

        }
        console.log(regdetails)

        if (firstName === "" && lastName === "") {
            alert("Enter the feileds")
        }
        else if (age === "" && email === "") {
            alert("Enter the feileds")

        }
        else if (password === "" && phoneNumber === "") {
            alert("Enter the feileds")

        }
        else if (location && isDesigner === "") {
            alert("Enter the feileds")
        }
        else {
            axios.post("http://localhost:8080/auth/create", regdetails)
                .then(res => {

                    if (res.data.data === "Internal server error ! ") {
                        alert("Failed to Register !")

                    }
                    else if (res.data.data === "user created successfully !") {
                        alert("Successfully user Register !")
                        window.location.href = '/login'
                    }

                })
        }
    }
    return (

        <>
            <div className="signup-bg py-2 container-fluid ">

                <div className="sigcard-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">

                    <h1 className=" text-center sigreg ">Registration Form</h1>
                    <form onSubmit={handleregister} className="text-center signinform"  >
                        <table className="mt-5 " >
                            <tr>
                                <th className="sigtxt " >First Name</th>
                                <td><input className="w-120 siginp" type="text" id="first_name" placeholder="Enter your name" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt"  >Last Name</th>
                                <td><input className="w-120 siginp" type="text" id="last_name" placeholder="Enter your last name" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt" >Age</th>
                                <td><input className="w-120 siginp" type="text" id="age" placeholder="Enter your age" /></td>
                            </tr>

                            <tr>
                                <th className="sigtxt">Email</th>
                                <td><input className="w-120 siginp" type="email" id="email" placeholder="Enter your mail" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt">Password</th>
                                <td><input className="w-120 siginp" type="password" id="password" placeholder="Enter your password" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt">Phone Number</th>
                                <td><input className="w-120 siginp" type="text" id="phone_number" placeholder="Enter your Number" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt">Location</th>
                                <td><input className="w-120 siginp" type="text" id="location" placeholder="Enter your location" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt">Roll</th>
                                <td><select className="w-120 siginp" id="isDesigner">
                                    <option >Select</option>
                                    <option value={0}>Customer</option>
                                    <option value={1}>Designer</option>

                                </select></td>
                            </tr>

                        </table>
                        <div className="text-center m-3 btsig">
                            <Link to='/login' className="btn  me-5  "><button className="sinbtn">LOGIN</button></Link>
                            <button className=" siglog  sinbtn  donebtn " type="submit">DONE</button>
                        </div>
                    </form>
                </div>
            </div>
        </>
    );
}


