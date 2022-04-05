import React from 'react'
import { Box } from '@mui/system'
import { Button, TextField, Typography } from '@mui/material'
import { useNavigate } from 'react-router-dom'

import styles from './styles'


function Register() {
    const navigate = useNavigate();

    const onRegisterButtonClicked = (event) => {
        navigate("/useraccount");
    }

    return (
        <Box sx={styles.container} >
            <Box sx={styles.imageContainer} >
                <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg'></img>
            </Box>
            <Box sx={styles.formContainer} >
                <Box sx={styles.form} >
                    <Typography variant='h4' align='center' >Register</Typography>
                    <TextField variant='outlined' label='Email' ></TextField>
                    <TextField variant='outlined' label='Password' ></TextField>
                    <TextField variant='outlined' label='Confirmation Password' ></TextField>
                    <Button onClick={onRegisterButtonClicked} variant='contained' >Register</Button>
                </Box>
            </Box>
        </Box>
    )
}

export default Register