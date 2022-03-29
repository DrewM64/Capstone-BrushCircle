import { Button, Typography, TextField } from '@mui/material';
import { Box } from '@mui/system';
import React from 'react'

import styles from './styles';
import './styles.css'

function AccountPanel(props) {
    const { value, index } = props;

    return (
        <Box role="tabpanel" id="account-panel" hidden={value !== index} sx={styles.container} >
            <Box sx={styles.accountHeader}>
                <Typography variant='h6' sx={styles.profileTitle} >Profile Details</Typography>
                <img className='profileImage' alt='profile' src='/stefan-stefancik-QXevDflbl8A-unsplash.jpg'></img>
                <Button variant='contained' sx={styles.uploadButton} >Upload new photo</Button>
                <Button variant='contained' sx={styles.resetbutton}>Reset</Button>
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