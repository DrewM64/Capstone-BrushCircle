import React, { useState } from 'react'
import Header from '../../components/Header/Header'
import { Box, Paper, Typography } from '@mui/material';

import createStyles from './styles';
import { Link } from 'react-router-dom';

function ImageView() {
    const [shrinkOverlay, setShrinkOverlay] = useState(false);
    const styles = createStyles({shrinkOverlay});

    // this method causes the styles to change for the
    // overlay section
    const onImageClicked = (event) => {
        setShrinkOverlay(!shrinkOverlay);
    }

    return (
        <Box sx={styles.container}>
            <Header />
            <Box sx={styles.imageContainer}>
                <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg' onClick={onImageClicked} ></img>
            </Box>
            <Paper onClick={onImageClicked}>
                <Box sx={styles.overlayContainer}>
                    <Box sx={styles.overlayHeader}>
                        <Typography variant='h4' >The Light That Shines Bright</Typography>
                        <Typography variant='h6' ml={3}>$499.00</Typography>
                        <Box sx={styles.authorColumn}>
                            <Typography>By: <Link to="">Stacy Woodard</Link></Typography>
                        </Box>
                    </Box>
                </Box>
            </Paper>
        </Box>
    )
}

export default ImageView