import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams ,Link} from "react-router-dom";

export function Vieworder() {
    const [vieworder, setVieworder] = useState([])
    var { s_no } = useParams()

    useEffect(() => {
        axios.get("http://localhost:8080/order/getoneorder/" + s_no)

            .then((res) => {
                console.log(res)
                setVieworder(res.data.jData)
            })
    }, [])
    function handledelete(sNo) {
        var data = { sNo: sNo }

        axios.delete("http://localhost:8080/order/deleteorder/"+sNo,data)
            .then((res) => {
                console.log(res)
                if (res.data.data === "user deleted successfully !") {
                    alert("Delete successfully !")
                   
                } else if (res.data.data === "Internal server error  !") {
                    alert("Data Are Not Deleted !")

                }
            })

    }
    return (
        <>
            {
                vieworder.map((val, index) => (
                    <>

                        <div class="card mt-5 m-auto   desviewpage " >
                            <h5 class="card-title text-center p-2 bg-info-subtle"><span className="text-primary ">{val.customerName}</span> has booking you !</h5>
                            <div class="card-body">
                                <h5 class="card-title">{val.dressModel}</h5>
                                <h5 class="card-title">{val.descriptionAboutDress}</h5>
                                <h5 class="card-title ">{val.registerMobileNumber}</h5>
                                <h5 class="card-title">{val.customerLocation}</h5>
                                <Link to='' onClick={() => { handledelete(val.sNo) }}><button className="btn2   ms-4"> DELETE</button></Link>

                            </div>

                        </div>
                    </>
                ))
            }
        </>
    );
}