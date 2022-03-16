import axios from 'axios';
import React, { useState } from 'react'

function UploadTest() {
    const [file, setFile] = useState(null);
    const [response, setResponse] = useState(null);

    //this will store the file in state when selected
    const onFileChange = (event) => {
        setFile(event.target.files[0]);
    }

    //event handler for when submitted
    const onFileUpload = () => {
        // const isEmpty = document.querySelector("#file").value;
        let formData = new FormData();

        formData.append("file", file, file.name);
        console.log(file);

        //send to the backend
        axios.post("http://localhost:8080/reactupload", formData).then((response) => {
            setResponse(response.data);
        }).catch((error) => {
            console.log(error);
        })
    }

    return (
        <div>
            <h1>Uplaod test</h1>
            <div>
                <input type="file"  id='file' onChange={onFileChange} />
                <button onClick={onFileUpload}>Upload</button>
                <h5>Server Response: {response}</h5>
            </div>
        </div>
    )
}

export default UploadTest