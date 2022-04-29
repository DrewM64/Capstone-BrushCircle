import React from 'react';
import { useSelector, useDispatch } from "react-redux";
import { Box } from '@mui/material';

import styles from './styles';
import './styles.css';
import { getGalleryProdctInfo } from "../../../../actions/productActions";

function GalleryItem(props) {
    const { index, currentIndex, clickAction, product } = props;
    const serverAddress = useSelector(state => state.Home.serverAddress);
    const dispatch = useDispatch();

    const onElementClicked = (e) => {
        dispatch(getGalleryProdctInfo(product));
        //if item already selected then return null to deselectit
        //else mark it selectrf
        if(index === currentIndex){
            clickAction(null);
        }else{
            clickAction(index);
        }
    }
    return (
        <Box sx={index === currentIndex ? styles.selected : styles.container} onClick={onElementClicked} >
            <img className='galleryImage' src={serverAddress + product.filename}></img>
        </Box>
    )
}

export default GalleryItem