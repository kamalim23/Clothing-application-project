import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";


export function Desprofile() {
    var { s_no } = useParams()
    const [firstName, setFirstname] = useState('');
    useEffect(() => {
        console.log(s_no)
        axios.get("http://localhost:8080/auth/getonedata/" + s_no)
            .then((res) => {
                console.log(res)
                setFirstname(res.data.jData.firstName)
            })
    }, [])

    function handleupload(event) {
        event.preventDefault()
        var designerName = document.getElementById("name").value
        var location = document.getElementById("location").value
        var qualification = document.getElementById("qualification").value
        var designerImage = document.getElementById("image").value
        var certification = document.getElementById("cert").value
        var prodetails = {

            designerName: designerName,
            location: location,
            qualification: qualification,
            designerImage: designerImage,
            certification: certification,
            sNo: s_no

        }
        console.log(prodetails)

        if (designerName === "" && location === "" && qualification === "") {
            alert("please enter the feilds")

        }
        else {
            axios.post("http://localhost:8080/designer/createDesigner", prodetails)
                .then(res => {
                    console.log(res)

                    if (res.data.data === "uploaded failed") {
                        alert(" Failed to upload !")

                    }
                    else if (res.data.data === "uploaded successfully") {
                        alert("Designer Created Successfully!")

                        window.location.href = `/desproview/${s_no}`
                    }
                })
        }

    }
    return (
        <>

            <div className=" py-2 container-fluid">

                <div className="deswork-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">

                    <h1 className=" text-center sigreg  despro  ">My Profile</h1>
                    <form onSubmit={handleupload}>
                        <table className="mt-5">
                            <tr>
                                <th className="sigtxt col-lg-3 " >Name</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="name" value={firstName} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Location</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="location" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Qualification</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="qualification" /></td>
                            </tr>

                            <tr>
                                <th className="sigtxt col-lg-3 ">Image</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="image" /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 " >Certification</th>
                                <td><input className="w-120 siginp col-lg-6" type="text " id="cert" /></td>
                            </tr>
                        </table>
                        <div className="text-center m-3 btsig">
                            <button className="btn2 " type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}