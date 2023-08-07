import Navigation from "../components/Navigation";
import Datepicker from "../components/Datepicker";
import Table from "../components/Table";
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import Form from 'react-bootstrap/Form';
import { Link } from "react-router-dom";

import React from 'react'

const Login = () => {
  return (
  <section className="vh-100">
      <div className="container-fluid">
        <div className="row">
          <div className="col-sm-6 text-black">

            <div className="px-5 ms-xl-4 pt-5">
            <img
              src="/images/logo.png"
              width="50"
              height="50"
              className="d-inline-block align-top"
              alt="Db logo"
            />
              <span className="h1 fw-bold mb-0" style={{color:"#1620a8"}}> Bonds Loader </span>
            </div>

            <div className="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

              <form style={{width: "23rem"}}>

                <h3 className="fw-normal mb-3 pb-3" style={{letterSpacing: "1px"}}>Log in</h3>

                <div className="form-outline mb-4">
                  <InputGroup className="mb-3">
                    <Form.Control
                      aria-label="Email"
                      className="form-control-lg"
                      aria-describedby="basic-addon1"
                    />
                  </InputGroup>
                  <label className="form-label" for="form2Example18">Email address</label>
                </div>

                <div className="form-outline mb-4">
                  <InputGroup className="mb-3">
                    <Form.Control
                      type="password"
                      aria-label="password"
                      className="form-control-lg"
                      aria-describedby="basic-addon1"
                    />
                  </InputGroup>
                  <label className="form-label" for="form2Example28">Password</label>
                </div>

                <div className="pt-1 mb-4">
                  <button className="btn btn-info btn-lg btn-block" type="button">Login</button>
                </div>

                <p className="small mb-5 pb-lg-2"><a className="text-muted" href="">Forgot password?</a></p>
                <p>Don't have a google account? <Link to="https://www.google.com/account/about/?hl=en-US">Register here</Link></p>

              </form>

            </div>

          </div>
          <div className="col-sm-6 px-0 d-none d-sm-block">
            <img src="/images/login.jpg"
              alt="Login image" className="w-100 vh-100" style={{objectFit: "cover", objectPosition: "left"}}/>
              Photo by <a href="https://unsplash.com/@jeffreyblum?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Jeffrey Blum</a> on <a href="https://unsplash.com/photos/7-gaPkhIgqs?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
          </div>
        </div>
      </div>
    </section>

  )
}

export default Login;


