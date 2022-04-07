import React, { useState, useEffect } from 'react';
import { Box } from '@mui/system';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import { useDispatch, useSelector } from 'react-redux';

import styles from './styles';
import createStyles from './containerStyles'; //this is needed to hide the second panel
import { Button, IconButton, Input, Stack, TextField, Typography } from '@mui/material';
import GalleryItem from './GalleryItem/GalleryItem';
import { getFileList, uploadFileToServer } from '../../../actions/imageActions';

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const [isEditOpen, setIsEditOpen] = useState(true);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const imageList = useSelector(state => state.ImageReducer.imageList);
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(getFileList());
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

    /* this is the event handler for the upload button.
    files are returned in an array even if only one
    file is selected. */
    const onFileSelected = (event) => {
        const newImage = event.target.files[0];

        //prepare the image then send it off
        let formData = new FormData();
        formData.append("file", newImage, newImage.name);
        dispatch(uploadFileToServer(formData));
    }

    return (
        <Box hidden={value == index ? false : true} sx={createStyles(value !== index)}>
            <Box padding={2} sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <label htmlFor='contained-button-file-1'>
                    <Input accept="image/*" id="contained-button-file-1" type="file" sx={{display: "none"}}  onChange={onFileSelected} />
                    <Button variant='contained' component='span'>Upload</Button>
                </label>
                <hr />
                <Box sx={styles.imagesList}>
                    {imageList?.map((img, arrayIndex) => {
                        return <GalleryItem clickAction={onGalleryItemClicked} currentIndex={selectedIndex} index={arrayIndex} key={arrayIndex} image={img} />
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
                    {imageList && <img src={'http://localhost:8080/' + imageList[selectedIndex]} alt='selected image'></img>}
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