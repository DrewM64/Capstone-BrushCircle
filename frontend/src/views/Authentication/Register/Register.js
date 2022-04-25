import React, { useState } from 'react'
import { Box } from '@mui/system'
import { Button, TextField, Typography } from '@mui/material'
import { useNavigate } from 'react-router-dom'

import styles from './styles'
import { registerUser } from '../../../actions/authenticationActions'
import { useDispatch } from 'react-redux'

function Register() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmationPassword, setConfirmationPassword] = useState("");
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const onRegisterButtonClicked = (event) => {
        const userInfo = {
            email,
            password,
            confirmationPassword,
        }

        dispatch(registerUser(userInfo));
        
    }

    const onEmailChanged = (event) => {
        setEmail(event.target.value);
    }

    const onPasswordChanged = (event) => {
        setPassword(event.target.value);
    }

    const onConfirmPasswordChanged = (event) => {
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
                    <TextField variant='outlined' label='Email' value={email} onChange={onEmailChanged}></TextField>
                    <TextField variant='outlined' type="password" label='Password' value={password} onChange={onPasswordChanged}></TextField>
                    <TextField variant='outlined' type="password" label='Confirmation Password' value={confirmationPassword} onChange={onConfirmPasswordChanged}></TextField>
                    <Button onClick={onRegisterButtonClicked} variant='contained' >Register</Button>
                </Box>
            </Box>
        </Box>
    )
}

export default Register