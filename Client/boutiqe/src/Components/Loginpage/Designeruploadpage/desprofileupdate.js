import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export function Desprofileupdate() {

    var { s_no } = useParams()
    console.log(s_no)

    const [designerName, setDesignername] = useState('')

    const [location, setLocation] = useState('')

    const [qualification, setQualification] = useState('')

    const [designerImage, setDesignerimage] = useState('')

    const [certification, setDesignercertification] = useState('')
    useEffect(() => {

        console.log(s_no)

        axios.get("http://localhost:8080/designer/getOneDesigner/" + s_no)

            .then((res) => {
                console.log(res)
                setDesignername(res.data.jData[0].designerName)
                setLocation(res.data.jData[0].location)
                setQualification(res.data.jData[0].qualification)
                setDesignerimage(res.data.jData[0].designerImage)
                setDesignercertification(res.data.jData[0].certification)

            })
    }, [])

    function handleupdate(event) {
        event.preventDefault()
        var designerName = document.getElementById("name").value

        var location = document.getElementById("location").value

        var qualification = document.getElementById("qualification").value

        var designerImage = document.getElementById("image").value

        var certification = document.getElementById("cert").value

        var desdetails = {

            designerName: designerName,
            location: location,
            qualification: qualification,
            designerImage: designerImage,
            certification: certification,
            sNo: s_no

        }
        console.log(desdetails)

        if (designerName === "" && location === "" && qualification === "") {
            alert("please enter the feilds")

        }
        else {
            axios.put("http://localhost:8080/designer/editDesigner", desdetails)
                .then(res => {
                    console.log(res)

                    if (res.data.data === "Internal server error !") {
                        alert(" Failed to upload !")

                    }
                    else if (res.data.data === "updated successfully !") {
                        alert("Designer edit  Successfully!")

                        window.location.href = `/desproview/${s_no}`


                    }
                })
        }
    }
    return (

        <>
            <div className=" py-2 container-fluid">

                <div className="deswork-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">

                    <h1 className=" text-center sigreg  despro">Edit  Your profile</h1>
                    <form onSubmit={handleupdate}>
                        <table className="mt-5">


                            <tr>
                                <th className="sigtxt col-lg-3 " >Name</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="name" value={designerName} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Location</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="location" value={location} onChange={(update) => { setLocation(update.target.value) }} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Qualification</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="qualification" value={qualification} onChange={(update) => { setQualification(update.target.value) }} /></td>
                            </tr>

                            <tr>
                                <th className="sigtxt col-lg-3 ">Image</th>
                                <td><input className="w-120 siginp col-lg-6" type="text" id="image" value={designerImage} onChange={(update) => { setDesignerimage(update.target.value) }} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 " >Certification</th>
                                <td><input className="w-120 siginp col-lg-6" type="text " id="cert" value={certification} onChange={(update) => { setDesignercertification(update.target.value) }} /></td>
                            </tr>
                        </table>
                        <div className="text-center m-3 btsig">
                            <button className="btn2 " type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </>
    );
}