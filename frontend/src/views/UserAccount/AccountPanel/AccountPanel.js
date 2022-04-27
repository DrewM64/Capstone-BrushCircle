import { Button, Typography, TextField, ButtonBase, Input, Paper } from '@mui/material';
import { Box } from '@mui/system';
import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';

import * as types from '../../../redux/constants';
import styles from './styles';
import './styles.css';
import { updateUser } from '../../../actions/authenticationActions';
import { uploadProfilePicture, resetProfilePicture } from '../../../actions/authenticationActions';
import { uploadFileToServer } from '../../../actions/imageActions';

function AccountPanel(props) {
    const { value, index } = props;
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [address, setAddress] = useState("");
    const [state, setState] = useState("");
    const [patreon, setPatreon] = useState("");
    const [cashapp, setCashapp] = useState("");
    const user = useSelector(state => state.Authentication.user);
    const profileImage = user.profileImageName;
    const dispatch = useDispatch();

    useEffect(() => {
        setFirstName(user.firstName || "");
        setLastName(user.lastName || "");
        setEmail(user.email || "");
        setPhoneNumber(user.phoneNumber || "");
        setAddress(user.address || "");
        setState(user.state || "");
        setPatreon(user.patreon || "");
        setCashapp(user.cashapp || "");
    }, [user])

    /* first uploads the picture to the server which 
    returns a link to the file. couldnt store the image in 
    redux so this was the alternative */
    const onUploadProfileImage = (event) => {
        const newImage = event.target.files[0];
        const formData = new FormData();
        formData.append("file", newImage, newImage.name);
        formData.append("user", new Blob([JSON.stringify(user)], {type:'application/json'}));
        console.log(new Blob([JSON.stringify(user)], {type:'application/json'}));
        dispatch(uploadProfilePicture(formData));
    }

    /* clears the profile image link in redux state
    which will clear the profile pic */
    const onResetButtonClicked = (event => {
        dispatch(resetProfilePicture(user));
    })

    const onLogoutButtonClicked = (event) => {
        dispatch({type: types.USER_LOGGED_OUT})
    }

    const onFirstNameChanged = (event) => {
        setFirstName(event.target.value);
    }

    const onLastNameChanged = (event) => {
        setLastName(event.target.value);
    }

    const onEmailChanged = (event) => {
        setEmail(event.target.value);
    }

    const onPhoneNumberChanged = (event) => {
        setPhoneNumber(event.target.value);
    }

    const onAddressChanged = (event) => {
        setAddress(event.target.value);
    }

    const onStateChanged = (event) => {
        setState(event.target.value);
    }

    const onPatreonChanged = (event) => {
        setPatreon(event.target.value);
    }

    const onCashappChanged = (event) => {
        setCashapp(event.target.value);
    }

    const onSaveButtonClicked = (event) => {
        const newUserInfo = {
            ...user,
            firstName,
            lastName,
            email,
            phoneNumber,
            address,
            state,
            patreon,
            cashapp,
        }

        dispatch(updateUser(newUserInfo));
    }

    return (
        <Box role="tabpanel" id="account-panel" hidden={value !== index} sx={styles.container} >
            <Box sx={styles.accountHeader}>
                <Typography variant='h6' sx={styles.profileTitle} >{user.email}</Typography>
                <Paper sx={styles.profileImageContainer}>
                    <img className='profileImage' alt='' src={'http://localhost:8000/' + profileImage}></img>
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
                <TextField label="First Name" value={firstName} onChange={onFirstNameChanged} />
                <TextField label="Last Name" value={lastName} onChange={onLastNameChanged} />
                <TextField label="Email" value={email} onChange={onEmailChanged} />
                <TextField label="Phone Number" value={phoneNumber} onChange={onPhoneNumberChanged} />
                <TextField label="Address" value={address} onChange={onAddressChanged} />
                <TextField label="State" value={state} onChange={onStateChanged} />
                <TextField label="Patreon" value={patreon} onChange={onPatreonChanged} />
                <TextField label="Cashapp" value={cashapp} onChange={onCashappChanged} />
            </Box>
            <Box sx={styles.buttonContainer}>
                <Button variant='contained' sx={styles.saveButton} onClick={onSaveButtonClicked}>Save Changes</Button>
                <Button variant='contained' sx={styles.logoutButton} onClick={onLogoutButtonClicked} >Logout</Button>
            </Box>
        </Box>
    )
}

export default AccountPanel