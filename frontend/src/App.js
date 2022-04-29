import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Route, Routes, Navigate } from 'react-router-dom';

import UploadTest from './views/UploadTest/UploadTest';
import SlidingMenuTest from './views/SlidingMenuTest/SlidingMenuTest';
import Register from './views/Authentication/Register/Register';
import Login from './views/Authentication/Login/Login';
import UserViewAccount from './views/UserAccount/UserAccount'
import UserProfile from './views/UserProfile/UserProfile';
import ImageView from './views/ImageView/ImageView';
import Home from './views/Home/Home';
import AppComponent from './components/AppComponent/AppComponent';
import { useSelector } from 'react-redux';
import Explore from './views/Explore/Explore';

function App() {
  const [messasge, setMessage] = useState("Hi");
  const user = useSelector(state => state.Authentication.user);
  localStorage.setItem("debug", "product, auth, admin, home");

  useEffect(() => {
    // axios.get('http://localhost:8080/')
    //   .then((response) => {
    //     setMessage(response.data)
    //   })
  })

  return (
    <Routes>
      <Route path='/' element={<Home />} />
      <Route path='/explore' element={<Explore />} />
      <Route path='/register' element={user ? <Navigate to="/app/useraccount" /> : <Register />} />
      <Route path='/login' element={user ? <Navigate to="/app/useraccount" /> : <Login />} />
      <Route path='/userprofile/:email' element={<UserProfile />} />
      <Route path='/imageview' element={<ImageView />} />
      <Route path='/app' element={user ? <AppComponent /> : <Navigate to="/login" />}>
        <Route path='useraccount' element={<UserViewAccount />} />
      </Route>

      {/* The following routes are for testing elements */}
      {/* <Route path='/test-upload' element={<UploadTest />} /> */}
      {/* <Route path='/test-menu' element={<SlidingMenuTest />} /> */}
    </Routes>
  );
}

export default App;
