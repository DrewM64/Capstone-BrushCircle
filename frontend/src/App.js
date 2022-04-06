import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Route, Routes, Navigate } from 'react-router-dom';

import UploadTest from './views/UploadTest/UploadTest';
import SlidingMenuTest from './views/SlidingMenuTest/SlidingMenuTest';
import Register from './views/Authentication/Register/Register';
import UserViewAccount from './views/UserAccount/UserAccount'
import UserProfile from './views/UserProfile/UserProfile';
import ImageView from './views/ImageView/ImageView';

function App() {
  const [messasge, setMessage] = useState("Hi");

  useEffect(() => {
    axios.get('http://localhost:8080/')
      .then((response) => {
        setMessage(response.data)
      })
  })

  return (
    <Routes>
      <Route path='/' element={<Navigate to={"/register"} />} />
      <Route path='/register' element={<Register />} />
      <Route path='/useraccount' element={<UserViewAccount />} />
      <Route path='/userprofile' element={<UserProfile />} />
      <Route path='/imageview' element={<ImageView />} />
      <Route path='/test-upload' element={<UploadTest />} />
      <Route path='/test-menu' element={<SlidingMenuTest />} />
    </Routes>
  );
}

export default App;
