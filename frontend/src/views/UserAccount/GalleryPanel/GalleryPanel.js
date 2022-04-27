import React, { useState, useEffect } from 'react';
import { Box } from '@mui/system';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import { useDispatch, useSelector } from 'react-redux';
import styles from './styles';
import createStyles from './containerStyles'; //this is needed to hide the second panel
import { Button, IconButton, Input, InputAdornment, Stack, Switch, TextField, Typography } from '@mui/material';
import GalleryItem from './GalleryItem/GalleryItem';
import { getFileList } from '../../../actions/imageActions';
import { uploadFile } from "../../../actions/productActions";
import { DesktopDatePicker } from '@mui/x-date-pickers';
import { upload } from '@testing-library/user-event/dist/upload';

function GalleryPanel(props) {
    const { value, index } = props;
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const [isEditOpen, setIsEditOpen] = useState(true);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const imageList = useSelector(state => state.ImageReducer.imageList);
    const user = useSelector(state => state.Authentication.user);
    const dispatch = useDispatch();
    const newProduct = {
        title: "",
        price: 0,
        style: "",
        featured: false,
        description: "",
        width: 0,
        length: 0,
        tags: "",
    }

    // useEffect(() => {
    //     dispatch(getFileList());
    // }, [])

    const onButtonPress = (event) => {
        setIsSidebarOpen(!isSidebarOpen);
    }

    const onDateChanged = (event) => {

    }

    const onEditButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    const onBackButtonClicked = (event) => {
        setIsEditOpen(!isEditOpen);
    }

    const onGalleryItemClicked = (index) => {
        setSelectedIndex(index);

        //if being deslected then the sidebar should close
        if (index == null) {
            setIsSidebarOpen(false);
        } else {
            setIsSidebarOpen(true);
        }
    }

    /* this is the event handler for the upload button.
    files are returned in an array even if only one
    file is selected. */
    const onUploadButtonPressed = (event) => {
        const newImage = event.target.files[0];

        //prepare the image then send it off
        let formData = new FormData();
        formData.append("file", newImage, newImage.name);
        formData.append("user", new Blob([JSON.stringify(user)], {type:'application/json'}));
        formData.append("product", new Blob([JSON.stringify(newProduct)], {type:'application/json'}));
        dispatch(uploadFile(formData));
    }

    return (
        <Box hidden={value == index ? false : true} sx={createStyles(value !== index)}>
            <Box padding={2} sx={isSidebarOpen ? styles.content : styles.contentExpanded}>
                <label htmlFor='contained-button-file-1'>
                    <Input accept="image/*" id="contained-button-file-1" type="file" sx={{ display: "none" }} onChange={onUploadButtonPressed} />
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
                        <IconButton sx={!isEditOpen ? styles.backActionButton : { display: "none" }} onClick={onBackButtonClicked}>
                            <ArrowBackOutlinedIcon sx={styles.actionButton} />
                        </IconButton>
                        <IconButton sx={!isEditOpen ? { display: "none" } : styles.rightActionButton} onClick={onEditButtonClicked}>
                            <EditOutlinedIcon />
                        </IconButton >
                        <IconButton sx={!isEditOpen ? { display: "none" } : styles.actionButton}>
                            <DeleteOutlineOutlinedIcon sx={styles.actionButton} />
                        </IconButton>
                    </Stack>
                </Box>
                <Box sx={isEditOpen ? styles.sidebarInfoContainer : styles.sidebarInfoContainerHidden}>
                    <Box sx={styles.imageContainer}>
                        {/* {imageList && <img src={'http://localhost:8080/' + imageList[selectedIndex]} alt='selected image'></img>} */}
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
                    <Box id='toggleSwitchContainer' sx={styles.toggleSwitchContainer}>
                        <Switch size='small'></Switch>
                    </Box>
                    <Typography sx={styles.descriptionLabel}>Description</Typography>
                    <Typography sx={styles.descriptionText}>Loren ipsum something something description for this nv
                        piece of work made by that guy from that place called edf
                        by the name in the event of something lorem lorem alr ed
                        ight lets end this</Typography>
                </Box>
                <Box sx={isEditOpen ? styles.sidebarFormContainerHidden : styles.sidebarFormContainer}>
                    <Box sx={styles.formGroup}>
                        <Typography>Title</Typography>
                        <TextField size='small'></TextField>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Date Created</Typography>
                        <DesktopDatePicker
                            inputFormat="MM/dd/yyyy"
                            onChange={onDateChanged}
                            renderInput={(params) => <TextField {...params} />}
                        />
                    </Box>
                    <Box>
                        <Typography>Price</Typography>
                        <TextField size='small' label='$' sx={styles.priceTextField}></TextField>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Style</Typography>
                        <TextField size="small"></TextField>
                    </Box>
                    <Box sx={styles.editToggleSwitchContainer}>
                        <Typography>Featured</Typography>
                        <Box id='toggleSwitchContainer' sx={styles.toggleSwitchContainer}>
                            <Switch size='small'></Switch>
                        </Box>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Description</Typography>
                        <TextField multiline rows={3}></TextField>
                    </Box>
                    <Box sx={styles.dimensionsContainer}>
                        <Box>
                            <Typography>Width</Typography>
                            <TextField
                                size='small'
                                InputProps={{ endAdornment: <InputAdornment position='end'>in</InputAdornment> }}
                            ></TextField>
                        </Box>
                        <Box>
                            <Typography>Length</Typography>
                            <TextField
                                size='small'
                                InputProps={{ endAdornment: <InputAdornment position='end'>in</InputAdornment> }}
                            ></TextField>
                        </Box>
                    </Box>
                    <Box sx={styles.formGroup}>
                        <Typography>Tags(Comma Separated) </Typography>
                        <TextField placeholder='Sky,Custom, ect..' size='small'></TextField>
                    </Box>
                    <Button variant='contained' sx={styles.saveButton} size='small'>Save Changes</Button>

                </Box>
            </Box>
        </Box>
    )
}

export default GalleryPanel