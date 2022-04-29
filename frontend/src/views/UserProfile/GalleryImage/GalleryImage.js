import React from 'react'
import { Box } from '@mui/material';

import makeStyles from './styles';
import { useSelector } from 'react-redux';
function GalleryImage(props) {
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

export default GalleryImage