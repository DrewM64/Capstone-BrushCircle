import { Box } from '@mui/material';
import React from 'react'

import makeStyles from './styles';
function FeaturedImage(props) {
    const styles = makeStyles();
    const { number, action } = props;

    return (
        <Box sx={styles.container} onClick={action}>
            {number}
        </Box>
    )
}

export default FeaturedImage