import axios from "axios";
import { Link, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
export function Cusviewpage() {
    const [datas, setDatas] = useState([])
    var { s_no } = useParams()
    console.log(s_no);
    useEffect(() => {
        axios.post("http://localhost:8080/designer/getAllDesigner")
            .then((res) => {
                console.log(res)
                setDatas(res.data.jData)
            })
    }, [])
    function handleemail(sNo) {
        var data = { sNo: sNo }
        console.log(data)
        alert("Email has been sended to your mail!.. Kindly checked it out!")
        axios.post("http://localhost:8080/mail/designer-booking/" + s_no, data)
    }
    return (
        <>
            {

                datas.map((val, inx) => (
                    <>
                        <div class="card mt-5 m-auto w-75  desviewpage">
                            <img src={val.designerImage} class="card-img-top desImage" alt="..." />
                            <div class="card-body m-auto">
                                <h5 class="card-title text-primary ">{val.designerName}</h5>
                                <h5 class="card-title text-primary">{val.location}</h5>
                                <h5 class="card-title text-primary">{val.qualification}</h5>
                                <h5 class="card-title text-primary">{val.certification}</h5>
                                <button className="butn" onClick={() => { handleemail(val.sNo) }}>Book Now</button> <Link to={`/getonedesigner/${val.sNo}`} ><button className=" butn">View more</button></Link>

                            </div>
                        </div>

                    </>
                ))
            }
        </>
    );
}