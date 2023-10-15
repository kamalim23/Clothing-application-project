import axios from "axios";
import { Link, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
export function Desupdasbord() {

    const { s_no } = useParams();
    const [datas, setDatas] = useState([])
    useEffect(() => {
        axios.get("http://localhost:8080/product/getOneProduct/" + s_no)

            .then((res) => {
                console.log(res)
                setDatas(res.data.jData)
            })
    }, [])
    function handledelete(sNo) {
        var data = { sNo: sNo }

        axios.post("http://localhost:8080/product/deleteProduct", data)
            .then((res) => {
                console.log(res)
                if (res.data.data === "user deleted successfully !") {
                    alert("Delete successfully !")
                } else if (res.data.data === "Internal server error  !") {
                    alert("Data Are Not Deleted !")

                }
            })

    }
    console.log(s_no);

    return (
        <>
            <Link to={`/editprofile/${s_no}`}><button className="btn2"> My profile </button> </Link>
            <Link to={`/desprofileview/${s_no}`}><button className="btn2"> View Profile </button> </Link>
          

                    {
                        datas.map((val, inx) => (

                            <div class="card mt-5 m-auto   desviewpage">
                                <img src={val.productImage} class="card-img-top productImage" alt="..." />
                                <div class="card-body">
                                    <h2 class="card-title bg-light text-warning ">{val.productName}</h2>
                                    <h5 class="card-title text-primary">{val.productDescription}</h5>
                                    <h5 class="card-title text-primary">{val.designerDescription}</h5>
                                    <h5 class="card-title text-primary">RS:{val.productRate}/-</h5>
                                    <Link to={`/edityourworks/${val.sNo}`}><button className="btn2"> EDIT</button> </Link>
                                    <Link to='' onClick={() => { handledelete(val.sNo) }}><button className="btn2   ms-4"> DELETE</button></Link>
                                </div>
                            </div>
                        ))
                    }
           

        </>
    );
}