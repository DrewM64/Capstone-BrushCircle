import { Box } from '@mui/material';
import React, { useEffect } from 'react'
import { useSelector } from 'react-redux';

import makeStyles from './styles';
function FeaturedImage(props) {
    const styles = makeStyles();
    const { action, product } = props;
    const serverAddress = useSelector(state => state.Home.serverAddress);

    const onProductClicked = (event) => {
        action(product);
    }

    return (
        <Box sx={styles.container} onClick={onProductClicked}>
            <img src={`${serverAddress}${product.filename}`}></img>
        </Box>
    )
}

export default FeaturedImage