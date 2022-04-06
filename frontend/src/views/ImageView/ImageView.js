import React from 'react'
import Header from '../../components/Header/Header'
import { Box, Paper } from '@mui/material';

import createStyles from './styles';

function ImageView() {
    const styles = createStyles();
    return (
        <Box sx={styles.container}>
            <Header />
            <Box sx={styles.imageContainer}>
                <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg'></img>
            </Box>
            <Paper>
                <Box sx={styles.overlayContainer}>
                    some content
                </Box>
            </Paper>
        </Box>
    )
}

export default ImageView