import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
export function Desprofileview() {

    var { s_no } = useParams()
    console.log(s_no)

    const [designerName, setDesignername] = useState('')
    const [location, setLocation] = useState('')
    const [qualification, setQualification] = useState('')
    const [designerimage, setDesignerimage] = useState('')
    const [designercertification, setDesignercertification] = useState('')
    useEffect(() => {
        axios.get("http://localhost:8080/designer/getOneDesigner/" + s_no)
            .then((res) => {
                setDesignername(res.data.jData[0].designerName)
                setLocation(res.data.jData[0].location)
                setQualification(res.data.jData[0].qualification)
                setDesignerimage(res.data.jData[0].designerImage)
                setDesignercertification(res.data.jData[0].certification)
                console.log(res)
            })
    }, [])
    return (
        <>
            <div class="card m-auto h-25 w-25  desprofileview mt-5 d-flex align-items-center">
                <img src={designerimage} class="card-img-top" alt="..." />
                <div class="card-body ">
                    <h5 class="card-title"><span className="text-primary "> {designerName}</span></h5>
                    <h5 class="card-title text-primary">{location}</h5>

                    <h5 class="card-title text-primary">{qualification}</h5>


                    <h5 className="card-title text-primary">{designercertification}</h5>

                    <Link to={`/desedit/${s_no}`}><button className="btn2 ms-4">EDIT</button> </Link>
                </div>
            </div>
        </>
    );
}