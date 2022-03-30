import React from 'react'
import { Box } from '@mui/material'

import styles from './styles';
import './styles.css';

function GalleryItem(props) {
    const { index, currentIndex, clickAction, image } = props;

    const onElementClicked = (e) => {
        e.preventDefault();

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
            <img className='galleryImage' src={'http://localhost:8080/' + image}></img>
        </Box>
    )
}

export default GalleryItem