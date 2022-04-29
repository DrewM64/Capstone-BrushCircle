import React, { useState } from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import SearchIcon from '@mui/icons-material/Search';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { IconButton, InputAdornment, TextField } from '@mui/material';
import { useSelector, useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'

import makeStyles from './styles';
import { search } from '../../actions/homeActions';

function Header() {
  const profileImage = useSelector(state => state.Authentication.profilePhoto);
  const user = useSelector(state => state.Authentication.user);
  const [query, setQuery] = useState("");
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const styles = makeStyles(user);
  const serverAddress = useSelector(state => state.Home.serverAddress);

  const onSearchButtonClicked = (event) => {
    dispatch(search(query));
  }

  const onProfileButtonClicked = (event) => {
    navigate("/app/useraccount");
  }

  const onHomeButtonClicked = (event) => {
    navigate("/");
  }

  const onExploreButtonClicked = (event) => {
    navigate("/explore");
  }

  const onSignupButtonClicked = (event) => {
    navigate("/register");
  }

  const onLoginButtonClicked = (event) => {
    navigate("/login");
  }

  const onQueryChanged = (event) => {
    setQuery(event.target.value);
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
            value={query}
            onChange={onQueryChanged}
          >
          </TextField>
          <Button color="inherit" onClick={onHomeButtonClicked}>Home</Button>
          <Button color="inherit" onClick={onExploreButtonClicked}>Explore</Button>
          <Button color="inherit" onClick={onSignupButtonClicked} sx={styles.signupButton}>Signup</Button>
          <Button color="inherit" onClick={onLoginButtonClicked} sx={styles.loginButton}>Login</Button>
          {user?.profileImageName ? <IconButton sx={styles.profileButton} onClick={onProfileButtonClicked}><img src={serverAddress + user?.profileImageName}></img></IconButton> : <IconButton onClick={onProfileButtonClicked}><AccountCircleIcon/></IconButton>}
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default Header