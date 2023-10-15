import React from "react";
import WelcomepImg from './WelcomeImg.png'
import { Link } from "react-router-dom";
export function Welcomepage() {
  return (


    <>
      

<div class="  " >
  <img src={WelcomepImg} class="card-img-top welCardHight" alt="..."/>
  <div class="card-body  ">
  </div>
 <div class="card-body d-flex justify-content-end  ">
    <Link  to="/Registration" class="card-link  btn bg-dark text-white me-4" >Registration</Link>
    <Link to="/login" class="card-link btn bg-dark text-white me-3">Login</Link>
  </div>
</div>



    </>
  );
}