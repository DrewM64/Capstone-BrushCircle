import React, { useState } from 'react'
import { Box } from '@mui/system'
import { Button, TextField, Typography } from '@mui/material'
import { useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux'

import styles from './styles'
import { register } from "../../../actions/authenticationActions"


function Register() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmationPassword, setConfirmationPassword] = useState("");
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const onRegisterButtonClicked = (event) => {
        // navigate("/useraccount");

        const formData = {
            email,
            password,
            confirmationPassword
        }

        dispatch(register(formData));
    }

    const onEmailFeildChanged = (event) => {
        setEmail(event.target.value);
    }

    const onPasswordFieldChanged = (event)=> {
        setPassword(event.target.value);
    }

    const onConfirmationPasswordChanged = (event) => {
        setConfirmationPassword(event.target.value);
    }

    return (
        <Box sx={styles.container} >
            <Box sx={styles.imageContainer} >
                <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg'></img>
            </Box>
            <Box sx={styles.formContainer} >
                <Box sx={styles.form} >
                    <Typography variant='h4' align='center' >Register</Typography>
                    <TextField variant='outlined' label='Email' value={email} onChange={onEmailFeildChanged} ></TextField>
                    <TextField variant='outlined' label='Password' value={password} onChange={onPasswordFieldChanged} ></TextField>
                    <TextField variant='outlined' label='Confirmation Password' value={confirmationPassword} onChange={onConfirmationPasswordChanged} ></TextField>
                    <Button onClick={onRegisterButtonClicked} variant='contained' >Register</Button>
                </Box>
            </Box>
        </Box>
    )
}

export default Register