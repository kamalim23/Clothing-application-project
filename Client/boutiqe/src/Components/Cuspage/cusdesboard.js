import React from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChessQueen } from "@fortawesome/free-solid-svg-icons";
export function Cusdesboard() {
  return (
    <>

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <h6 class="navbar-brand  welcome" ><FontAwesomeIcon icon={faChessQueen} style={{ color: "#c20fb3", }} />   Welcome you</h6>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse " id="navbarNavAltMarkup">
            <div class="navbar-nav">
            </div>
          </div>
        </div>
        <div>
          <Link to='/login'><input type="button" className="btn btn-danger" value='Logout' /></Link>
          </div>
      </nav>


    </>


  );
}