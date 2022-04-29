import { Box } from '@mui/material';
import React, { useState } from 'react'
import { useSelector, useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import debug from 'debug';
import { getProductInfo } from '../../actions/homeActions';

import makeStyles from './styles';

function HomeProduct(props) {
    const styles = makeStyles();
    const { product } = props;
    const serverAddress = useSelector(state => state.Home.serverAddress);
    const output = debug("home");
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const onProductClicked = (event) => {
        dispatch(getProductInfo(product));
        navigate("/imageview");
    }

    return (
        <Box sx={styles.container} onClick={onProductClicked}>
            <img src={serverAddress + product.filename}></img>
        </Box>
    )
}

export default HomeProduct