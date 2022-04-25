import React from 'react'
import { Box } from '@mui/material';

import makeStyles from './styles';
function GalleryImage(props) {
    const styles = makeStyles();
    const { number, action } = props;

    return (
        <Box sx={styles.container} onClick={action}>
            {number}
        </Box>
    )
}

export default GalleryImage