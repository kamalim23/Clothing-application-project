import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
export function Desupdatepage() {
    var { s_no } = useParams()
    const [productname, setProductname] = useState('')

    const [productdescription, setProducdescription] = useState('')

    const [productimage, setProductimage] = useState('')

    const [productrate, setProductrate] = useState('')

    const [designerdescription, setDesignerdescription] = useState('')
    useEffect(() => {
        console.log(s_no)
        axios.get("http://localhost:8080/product/getonedata/" + s_no)
            .then((res) => {
                console.log(res)
                setProductname(res.data.jData[0].productName)
                setProducdescription(res.data.jData[0].productDescription)
                setProductimage(res.data.jData[0].productImage)
                setProductrate(res.data.jData[0].productRate)
                setDesignerdescription(res.data.jData[0].designerDescription)

            })
    }, [])
    function handleregister(event) {
        event.preventDefault()
        var productName = document.getElementById("product_name").value
        var productDescription = document.getElementById("product_description").value
        var productImage = document.getElementById("product_image").value
        var productRate = document.getElementById("product_price").value
        var designerDescription = document.getElementById("designer_description").value
        var prodetails = {

            sNo: s_no,
            productName: productName,
            productDescription: productDescription,
            productImage: productImage,
            productRate: productRate,
            designerDescription: designerDescription,


        }
        if (productName === "" && productDescription === "" && productImage === "" && productRate === "" && designerDescription === "") {
            alert("please enter the feilds")
        }
        else {
            axios.put("http://localhost:8080/product/editProduct/" + s_no, prodetails)
                .then((res) => {
                    console.log(res)
                    if (res.data.data === "Internal server error !") {
                        alert("Failed to updated ! ")
                    }
                    else if (res.data.data === "updated successfully !") {
                        console.log(res)
                        alert(" Changes updated Succesccfully !")
                        window.location.href = `/desuppage/${res.data.jData[0].createdBy}`
                    }

                })
        }

    }
    return (

        <>
            <div className=" py-2 container-fluid">

                <div className="deswork-background card mt-5 p-5 w-80 shadow-lg d-flex justify-content-center container">

                    <h1 className=" text-center sigreg  despro">Edit  Your Works</h1>
                    <form onSubmit={handleregister}>
                        <table className="mt-5">
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Name</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_name" value={productname} onChange={(update) => { setProductname(update.target.value) }} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Description</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_description" value={productdescription} onChange={(update) => { setProducdescription(update.target.value) }} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Image</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_image" value={productimage} onChange={(update) => { setProductimage(update.target.value) }} /></td>
                            </tr>

                            <tr>
                                <th className="sigtxt col-lg-3 ">Product Price</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text" id="product_price" value={productrate} onChange={(update) => { setProductrate(update.target.value) }} /></td>
                            </tr>
                            <tr>
                                <th className="sigtxt col-lg-3 ">Desiger Description</th>
                                <td><input className="w-120 siginp col-lg-6 " type="text " id="designer_description" value={designerdescription} onChange={(update) => { setDesignerdescription(update.target.value) }} /></td>
                            </tr>
                        </table>
                        <div className="text-center m-3 btsig">
                            <button className="btn2 " type="submit">update</button>
                        </div>
                    </form>

                </div>
            </div>
        </>
    );
}