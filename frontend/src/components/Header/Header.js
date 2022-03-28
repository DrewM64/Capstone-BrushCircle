import React from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { SvgIcon } from '@mui/material';

import styles from './styles';

function Header() {
  return (
    <Box sx={styles.container}>
      <AppBar position="static" color='primaryButtonColor' elevation={0}>
        <Toolbar sx={styles.toolbar}>
          <img  src='/brushcircle-logo.png' alt='selected image' height={250}></img>

          <Typography variant="h6" component="a" sx={{ flexGrow: 1 }}>
            BrushCircle
          </Typography>
          <Button color="inherit">Login</Button>
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default Header