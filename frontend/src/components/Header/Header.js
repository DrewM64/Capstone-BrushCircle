import React from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import SearchIcon from '@mui/icons-material/Search';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { IconButton, InputAdornment, TextField } from '@mui/material';
import { useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'

import makeStyles from './styles';

function Header() {
  const profileImage = useSelector(state => state.Authentication.profilePhoto);
  const user = useSelector(state => state.Authentication.user);
  const navigate = useNavigate();
  const styles = makeStyles(user);

  const onProfileButtonClicked = (event) => {
    navigate("/app/useraccount");
  }

  const onHomeButtonClicked = (event) => {
    navigate("/userprofile");
  }

  return (
    <Box sx={styles.container}>
      <AppBar position="static" color='primaryButtonColor' elevation={0}>
        <Toolbar sx={styles.toolbar}>
          <img src='/brushcircle-logo.png' alt='selected' height={250}></img>

          <Typography variant="h5">
            BrushCircle
          </Typography>
          <TextField
            sx={styles.searchInput}
            placeholder="Search"
            size='small'
            InputProps={{
              startAdornment: <InputAdornment position='start'><SearchIcon /></InputAdornment>
            }}
          >
          </TextField>
          <Button color="inherit" onClick={onHomeButtonClicked}>Home</Button>
          <Button color="inherit">Explore</Button>
          <Button color="inherit" sx={styles.signupButton}>Signup</Button>
          <Button color="inherit" sx={styles.loginButton}>Login</Button>
          {user.profileImage ? <IconButton sx={styles.profileButton} onClick={onProfileButtonClicked}><img src={profileImage}></img></IconButton> : <IconButton onClick={onProfileButtonClicked}><AccountCircleIcon/></IconButton>}
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default Header