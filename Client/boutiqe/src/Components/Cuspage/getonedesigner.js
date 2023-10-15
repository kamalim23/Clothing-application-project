import axios from "axios";
import { Link, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";

export function Getoneproduct() {
    const { s_no } = useParams();
    const [datas, setDatas] = useState([])
    useEffect(() => {
        axios.get("http://localhost:8080/product/getallproductbyspecificdes/" + s_no)

            .then((res) => {
                console.log(res)
                setDatas(res.data.jData)
            })


    }, [])

    return (
        <>
              
                    {
                        datas.map((val, inx) => (
                            <div class="card mt-5 m-auto   desviewpage">
                                <img src={val.productImage} class="card-img-top productImage" alt="..." />
                                <div class="card-body">
                                    <h5 class="card-title text-primary  bg-light text-warning ">{val.productName}</h5>
                                    <h2 class="card-title text-primary">{val.productDescription}</h2>
                                    <h5 class="card-title text-primary">{val.designerDescription}</h5>
                                    <h5 class="card-title text-primary">{val.productRate}</h5>
                                    <h5 class="card-title text-primary">{val.designerName}</h5>
                                </div>
                            </div>
                        ))
                    }

              
          
        </>
    )
}