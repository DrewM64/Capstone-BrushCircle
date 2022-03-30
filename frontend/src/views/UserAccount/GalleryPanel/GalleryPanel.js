import React, { useState, useEffect } from 'react'
import { Box } from '@mui/system';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import { useDispatch } from 'react-redux';

import styles from './styles';
import createStyles from './containerStyles'; //this is needed to hide the second panel
import { Button, IconButton, Stack, TextField, Typography } from '@mui/material';
import GalleryItem from './GalleryItem/GalleryItem';
import { getFileList } from '../../../actions/imageActions'

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const [isEditOpen, setIsEditOpen] = useState(true);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const indexes = [1,2,3,4,5,6,7,8,9,10];
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(getFileList())
    }, [])

    const onButtonPress = (event) => {
        setIsSidebarOpen(!isSidebarOpen);
    }

    const onEditButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    const onBackButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    const onGalleryItemClicked = (index) => {
        setSelectedIndex(index);

        //if being deslected then the sizebar should close
        if(index == null){
            setIsSidebarOpen(false);
        }else{
            setIsSidebarOpen(true);
        }
    }

    return (
        <Box hidden={value == index ? false : true} sx={createStyles(value !== index)}>
            <Box padding={2} sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <Button variant='contained' sx={styles.uploadButton} onClick={onButtonPress}>Upload New</Button>
                <hr />
                <Box sx={styles.imagesList}>
                    {indexes.map((value, arrayIndex) => {
                        return <GalleryItem clickAction={onGalleryItemClicked} currentIndex={selectedIndex} index={arrayIndex} key={arrayIndex} />
                    })}
                </Box>
            </Box>
            <Box sx={isSidebarOpen ? styles.rightSidebar : styles.rightSidebarClosed}>
                <Box id="actionBar" sx={styles.actionBar} >
                    <Stack direction="row"  >
                        <IconButton sx={!isEditOpen? styles.backActionButton : {display: "none"}} onClick={onBackButtonClicked}>
                            <ArrowBackOutlinedIcon sx={styles.actionButton}/>
                        </IconButton>
                        <IconButton sx={!isEditOpen ? {display: "none"} : styles.rightActionButton} onClick={onEditButtonClicked}>
                            <EditOutlinedIcon />
                        </IconButton >
                        <IconButton sx={!isEditOpen ? {display: "none"} : styles.actionButton}>
                            <DeleteOutlineOutlinedIcon sx={styles.actionButton} />
                        </IconButton>
                    </Stack>
                </Box>
                <Box sx={isEditOpen ?  styles.sidebarInfoContainer : styles.sidebarInfoContainerHidden}>
                    <Box sx={styles.imageContainer}>
                    <img src='/david-zieglgansberger--M_J7gGTg6k-unsplash.jpg' alt='selected image'></img>
                    </Box>
                    <Typography>Title</Typography>
                    <Typography align='right'>The light that shines bright</Typography>
                    <Typography>Price</Typography>
                    <Typography align='right'>$344.00</Typography>
                    <Typography>Size</Typography>
                    <Typography align='right'>23 x 16</Typography>
                    <Typography>Tags</Typography>
                    <Typography align='right'>custom, acrylic</Typography>
                    <Typography>Date Created</Typography>
                    <Typography align='right'>1/12/2004</Typography>
                    <Typography>Featured</Typography>
                    <Typography align='right'>True</Typography>
                </Box>
                <Box sx={isEditOpen ? styles.sidebarFormContainerHidden : styles.sidebarFormContainer}>
                    <Typography>Title</Typography>
                    <TextField></TextField>
                    <Typography>Date Created</Typography>
                    <TextField></TextField>
                    <Typography>Size</Typography>
                    <Typography>Tags</Typography>
                    <TextField multiline rows={5}></TextField>
                    <Typography>Category</Typography>
                    <Typography>Featured</Typography>
                    <Button variant='contained' sx={styles.saveButton}>Save Changes</Button>
                    
                </Box>
            </Box>
        </Box>
    )
}

export default GalleryPanel