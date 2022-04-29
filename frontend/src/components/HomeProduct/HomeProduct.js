import { Box } from '@mui/material';
import React from 'react'

import makeStyles from './styles';

function HomeProduct(props) {
    const styles = makeStyles();
    const { product } = props;

    return (
        <Box sx={styles.container}>
            <img src={product.filename}></img>
        </Box>
    )
}

export default HomeProduct