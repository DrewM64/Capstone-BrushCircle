import React, { useState } from 'react'
import Header from '../../components/Header/Header'
import { Box, Paper, Typography } from '@mui/material';

import createStyles from './styles';
import { Link } from 'react-router-dom';

function ImageView() {
    const [shrinkOverlay, setShrinkOverlay] = useState(false);
    const styles = createStyles({ shrinkOverlay });

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
                        <Typography variant='h4' fontWeight={600}>The Light That Shines Bright</Typography>
                        <Typography variant='h6' ml={3} color='primary'>$499.00</Typography>
                        <Box sx={styles.authorColumn}>
                            <Typography>By: <Link to="">Stacy Woodard</Link></Typography>
                        </Box>
                    </Box>
                    <Box sx={styles.detailsContainer}>
                        <Box sx={styles.dateContainer}>
                            <Typography variant='subtitle1'>Date Created</Typography>
                            <Typography variant='h5' color='primary'>10/26/2006</Typography>
                        </Box>
                        <Box sx={styles.biographyContainer}>
                            <Typography variant='body1' color='primary'>This is a lovely piece that was created by Stacy
                                Woodard, who created this piece just after giving
                                birth to her first child. This piece presents a
                                modern look and represents the beautiful splash
                                of the energy of life.</Typography>
                        </Box>
                        <Box sx={styles.attributesContainer}>
                            <Typography variant='subtitle1' align='right'>Dimensions</Typography>
                            <Typography variant='h6' color='primary'>40 x 50</Typography>
                            <Typography variant='subtitle1' align='right'>Style</Typography>
                            <Typography variant='h6' color='primary'>Abstract</Typography>
                            <Typography variant='subtitle1' align='right'>Tags</Typography>
                            <Typography variant='h6' color='primary'>pink, abstract</Typography>
                        </Box>
                    </Box>
                </Box>
            </Paper>
        </Box>
    )
}

export default ImageView