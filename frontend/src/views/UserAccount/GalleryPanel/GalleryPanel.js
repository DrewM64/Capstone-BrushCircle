import React, { useState } from 'react'
import { Box } from '@mui/system';

import styles from './styles';
import { Button } from '@mui/material';

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);

    const onButtonPress = (event) => {
        setIsSidebarOpen(!isSidebarOpen)
    }

    return (
        <Box hidden={value !== index} sx={styles.container}>
            <Box sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <Button variant='contained' onClick={onButtonPress}>Upload New</Button>
            </Box>
            <Box sx={isSidebarOpen ? styles.rightSidebar : styles.rightSidebarClosed}>
                Right sidebar
            </Box>
        </Box>
    )
}

export default GalleryPanel