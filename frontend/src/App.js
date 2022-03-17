import logo from './logo.svg';
import './App.css';import { useEffect, useState } from 'react';
import axios from 'axios';
import { Route, Routes } from 'react-router-dom';
import UploadTest from './views/UploadTest/UploadTest';
import SlidingMenuTest from './views/SlidingMenuTest/SlidingMenuTest';

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
      <Route path='/test-upload' element={<UploadTest />} />
      <Route path='/test-menu' element={<SlidingMenuTest />} />
    </Routes>
  );
}

export default App;
