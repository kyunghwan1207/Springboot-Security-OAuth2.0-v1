import React from "react";
import Nav from "../components/Nav/Nav";
import { useNavigate } from "react-router-dom";
const Profile = () => {
  let navigate = useNavigate();
  return (
    <>
      <Nav navigate={navigate} />
    </>
  );
};

export default Profile;
