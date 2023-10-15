import React from "react";
import { Link, useParams } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChessQueen } from "@fortawesome/free-solid-svg-icons";
export function Desuppage() {
  var { s_no } = useParams()
  console.log(s_no)


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
              <Link to={`/desuploadpage/${s_no}`} class="nav-link active   desnav"><h6 class="desnav">Upload your works</h6></Link>
              <Link to={`/vieworder/${s_no}`} class="nav-link active desnav"><h6 class="desnav">View notifications</h6></Link>
            </div>
          </div>
          <div class=" collapse navbar-collapse myprofile desnavpro" id="navbarNavAltMarkup">
          </div>
        </div>
        <div>
          <Link to='/login'><input type="button" className="btn btn-danger" value='Logout' /></Link>
          </div>
      </nav>
    </>
  );
}