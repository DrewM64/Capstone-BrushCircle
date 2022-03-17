import axios from 'axios';
import React, { useEffect, useState } from 'react'

import './styles.css';

/* NOTES

    When files are recieved on the backend we should remove
    spaces from the filenames. This was previously causing me issues.
*/

function UploadTest() {
    const [file, setFile] = useState(null);
    const [response, setResponse] = useState(null);
    const [fileList, setFileList] = useState(null);

    //this will store the file in local state when selected
    const onFileChange = (event) => {
        setFile(event.target.files[0]);
    }

    /* will get a list of files from the backend so
    we know what to request */
    const getFileList = () => {
        axios.get("http://localhost:8080/testfilelist").then((response) => {
            setFileList(response.data);
        }).catch((error) => {
            console.log(error);
        })
    }

    //event handler for when submitted
    const onFileUpload = () => {
        let formData = new FormData();

        formData.append("file", file, file.name);
        console.log(file);

        //send to the backend
        axios.post("http://localhost:8080/reactupload", formData).then((response) => {
            setResponse(response.data);
            getFileList();
        }).catch((error) => {
            console.log(error);
        })    
    }

    //this will run 1 time upon component mount
    useEffect(() => {
        getFileList()
    }, [])

    return (
        <div>
            <h1>Uplaod test</h1>
            <h3>First select an image file then click upload</h3>
            <div>
                <input type="file"  id='file' onChange={onFileChange} />
                <button onClick={onFileUpload}>Upload</button>
                <h5>Server Response: </h5> <span>{response}</span>
            </div>
            <hr />
            <div id='image-container'>
                <h4>Images will display here when uploaded:</h4>
                {fileList?.map((item, index) => {
                    return (<img src={'http://localhost:8080/' + item}></img>)
                })}
            </div>
        </div>
    )
}

export default UploadTest