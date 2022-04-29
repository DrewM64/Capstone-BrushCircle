import React, { useState } from 'react'
import { Box } from '@mui/system'
import { Button, TextField, Typography } from '@mui/material'
import { Link, useNavigate } from 'react-router-dom'

import makeStyles from './styles'
import { loginUser } from '../../../actions/authenticationActions'
import { useDispatch } from 'react-redux'

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const styles = makeStyles();
    const dispatch = useDispatch();

    const onLoginButtonClicked = (event) => {
        const userInfo = {
            email,
            password,
        }

        dispatch(loginUser(userInfo));
        
    }

    const onEmailChanged = (event) => {
        setEmail(event.target.value);
    }
    
    const onPasswordChanged = (event) => {
        setPassword(event.target.value);
    }

    return (
        <Box sx={styles.container} >
            <Box sx={styles.imageContainer} >
                <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg'></img>
            </Box>
            <Box sx={styles.formContainer} >
                <Box sx={styles.form} >
                    <Typography variant='h4' align='center' >Login</Typography>
                    <Typography align="center">Dont have an account? <Link to="/register">Sign Up</Link></Typography>
                    <TextField variant='outlined' label='Email' value={email} onChange={onEmailChanged}></TextField>
                    <TextField variant='outlined' type="password" label='Password' value={password} onChange={onPasswordChanged}></TextField>
                    <Button onClick={onLoginButtonClicked} size="large" variant='contained' >Login</Button>
                </Box>
            </Box>
        </Box>
    )
}

export default Login