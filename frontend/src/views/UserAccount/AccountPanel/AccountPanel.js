import { Button, Typography, TextField, ButtonBase, Input, Paper } from '@mui/material';
import { Box } from '@mui/system';
import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';

import * as types from '../../../redux/constants';
import styles from './styles';
import './styles.css'
import { uploadProfilePicture, resetProfilePicture } from '../../../actions/authenticationActions';
import { uploadFileToServer } from '../../../actions/imageActions';

function AccountPanel(props) {
    const { value, index } = props;
    const profileImage = useSelector(state => state.Authentication.profilePhoto);
    const user = useSelector(state => state.Authentication.user);
    const dispatch = useDispatch();

    /* first uploads the picture to the server which 
    returns a link to the file. couldnt store the image in 
    redux so this was the alternative */
    const onUploadProfileImage = (event) => {
        const newImage = event.target.files[0];
        const formData = new FormData();
        formData.append("file", newImage, newImage.name);

        dispatch(uploadProfilePicture(formData));
    }


    /* clears the profile image link in redux state
    which will clear the profile pic */
    const onResetButtonClicked = (event => {
        dispatch(resetProfilePicture());
    })

    return (
        <Box role="tabpanel" id="account-panel" hidden={value !== index} sx={styles.container} >
            <Box sx={styles.accountHeader}>
                <Typography variant='h6' sx={styles.profileTitle} >{user.email}</Typography>
                <Paper sx={styles.profileImageContainer}>
                    <img className='profileImage' alt='' src={'http://localhost:8080/' + profileImage}></img>
                </Paper>
                <label htmlFor='contained-button-file-2'>
                    <Input accept="image/*" id="contained-button-file-2" type="file" sx={{ display: "none" }} onChange={onUploadProfileImage} />
                    <Button variant='contained' component='span' sx={styles.uploadButton}>Upload Image</Button>
                </label>
                <Button variant='contained' onClick={onResetButtonClicked} sx={styles.resetbutton}>Reset</Button>
                <Typography sx={styles.subtitle} >Allowed JPG,GIF,PNG</Typography>
            </Box>
            <hr />
            <Box sx={styles.formContainer} >
                <TextField label="First Name" />
                <TextField label="Last Name" />
                <TextField label="Email" />
                <TextField label="Phone Number" />
                <TextField label="Address" />
                <TextField label="State" />
                <TextField label="Patreon" />
                <TextField label="Cashapp" />
            </Box>
            <Box sx={styles.buttonContainer}>
                <Button variant='contained' sx={styles.saveButton}>Save Changes</Button>
                <Button variant='contained' >Cancel</Button>
            </Box>
        </Box>
    )
}

export default AccountPanel