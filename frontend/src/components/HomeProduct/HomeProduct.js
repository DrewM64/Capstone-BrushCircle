import { Box } from '@mui/material';
import React, { useState } from 'react'
import { useSelector } from 'react-redux';

import makeStyles from './styles';

function HomeProduct(props) {
    const styles = makeStyles();
    const { product } = props;
    const serverAddress = useSelector(state => state.Home.serverAddress);

    return (
        <Box sx={styles.container}>
            <img src={serverAddress + product.filename}></img>
        </Box>
    )
}

export default HomeProduct