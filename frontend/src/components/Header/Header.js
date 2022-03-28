import React from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import SearchIcon from '@mui/icons-material/Search';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { IconButton, InputAdornment, TextField } from '@mui/material';

import styles from './styles';

function Header() {
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
          <Button color="inherit">Home</Button>
          <Button color="inherit">Explore</Button>
          <Button color="inherit">Signup</Button>
          <Button color="inherit">Login</Button>
          <IconButton><AccountCircleIcon/></IconButton>
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default Header