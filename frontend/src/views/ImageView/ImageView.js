import React, { useState } from 'react'
import Header from '../../components/Header/Header'
import { Box, Paper, Typography } from '@mui/material';

import createStyles from './styles';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

function ImageView() {
    const [shrinkOverlay, setShrinkOverlay] = useState(false);
    const styles = createStyles({ shrinkOverlay });
    const selectedProduct = useSelector(state => state.Home.selectedProduct);
    const serverAddress = useSelector(state => state.Home.serverAddress);

    // this method causes the styles to change for the
    // overlay section
    const onImageClicked = (event) => {
        setShrinkOverlay(!shrinkOverlay);
    }

    return (
        <Box sx={styles.container}>
            <Header />
            <Box sx={styles.imageContainer}>
                <img src={`${serverAddress}${selectedProduct?.filename}`} onClick={onImageClicked} ></img>
            </Box>
            <Paper onClick={onImageClicked}>
                <Box sx={styles.overlayContainer}>
                    <Box sx={styles.overlayHeader}>
                        <Typography variant='h4' fontWeight={600}>{selectedProduct?.title}</Typography>
                        <Typography variant='h6' ml={3} color='primary'>{"$" + selectedProduct?.price}</Typography>
                        <Box sx={styles.authorColumn}>
                            <Typography>By: <Link to={`/userprofile/${selectedProduct?.user.email}`}>{selectedProduct?.user.firstName != "" || selectedProduct?.user.lastName != "" ? `${selectedProduct?.user.firstName} ${selectedProduct?.user.lastName}` : selectedProduct?.user.email}</Link></Typography>
                        </Box>
                    </Box>
                    <Box sx={styles.detailsContainer}>
                        <Box sx={styles.dateContainer}>
                            <Typography variant='subtitle1'>Date Created</Typography>
                            <Typography variant='h5' color='primary'>{selectedProduct?.date}</Typography>
                        </Box>
                        <Box sx={styles.biographyContainer}>
                            <Typography variant='body1' color='primary'>{selectedProduct?.description}</Typography>
                        </Box>
                        <Box sx={styles.attributesContainer}>
                            <Typography variant='subtitle1' align='right'>Dimensions</Typography>
                            <Typography variant='h6' color='primary'>{selectedProduct?.width} x {selectedProduct?.length}</Typography>
                            <Typography variant='subtitle1' align='right'>Style</Typography>
                            <Typography variant='h6' color='primary'>{selectedProduct?.style}</Typography>
                            <Typography variant='subtitle1' align='right'>Tags</Typography>
                            <Typography variant='h6' color='primary'>{selectedProduct?.tags}</Typography>
                        </Box>
                    </Box>
                </Box>
            </Paper>
        </Box>
    )
}

export default ImageView