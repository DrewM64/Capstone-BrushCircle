import React, { useState } from 'react'
import { Box } from '@mui/system';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';

import styles from './styles';
import createStyles from './containerStyles'; //this is needed to hide the second panel
import { Button, IconButton, Stack } from '@mui/material';

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);

    const onButtonPress = (event) => {
        setIsSidebarOpen(!isSidebarOpen)
    }

    return (
        <Box hidden={value == index ? false : true} sx={createStyles(value !== index)}>
            <Box padding={2} sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <Button variant='contained' sx={styles.uploadButton} onClick={onButtonPress}>Upload New</Button>
                <hr />
                <Box sx={styles.imagesList}>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                    <div class="box"></div>
                </Box>
            </Box>
            <Box sx={isSidebarOpen ? styles.rightSidebar : styles.rightSidebarClosed}>
                <Box id="actionBar" sx={styles.actionBar} >
                    <Stack direction="row" spacing={1} >
                        <IconButton>
                            <EditOutlinedIcon />
                        </IconButton>
                    </Stack>
                </Box>
            </Box>
        </Box>
    )
}

export default GalleryPanel