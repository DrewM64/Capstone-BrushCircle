import { Box, TextField, InputAdornment, Button, IconButton, Typography, TableContainer, Paper, Table, TableHead, TableRow, Tab, TableCell, TableBody, Stack, Switch } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import React, { useState } from 'react';
import PersonAddAltIcon from '@mui/icons-material/PersonAddAlt';
import { DesktopDatePicker } from '@mui/x-date-pickers';

import makeStyles from './styles'
import AdminGalleryItem from './AdminGalleryItem/AdminGalleryItem';

function AdminPanel(props) {
    const { value, index } = props;
    const [isUserSelected, setIsUserSelected] = useState(false);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const [isSidebarOpen, setIsSidebarOpen] = useState(true);
    const [isUserProductSelected, setIsUserProductSelected] = useState(false);
    const [toggleInfoEdit, setToggleInfoEdit] = useState(false);
    const [toggleProductEdit, setToggleProductEdit] = useState(false);
    const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18];

    //state variables are passed to this style function to update the UI
    const styles = makeStyles(
        value,
        index,
        isUserSelected,
        isSidebarOpen,
        isUserProductSelected,
        toggleInfoEdit,
        toggleProductEdit,
    );

    const onTableRowClicked = (event) => {
        setIsUserSelected(true);
    }

    const onMainBackButtonClicked = (event) => {
        setIsUserSelected(false);
    }

    const onGalleryItemClicked = (index) => {
        setSelectedIndex(index);

        //if being deselected then the edit panel should close
        if (index == null) {
            setIsUserProductSelected(false);
            setToggleInfoEdit(false);
            setToggleProductEdit(false);
        } else {
            setIsUserProductSelected(true)
            setToggleInfoEdit(false);
            setToggleProductEdit(false);
        }
    }

    const onEditButtonClicked = (event) => {
        if (isUserProductSelected) {
            setToggleProductEdit(true);
        } else {
            setToggleInfoEdit(true);
        }
    }

    const onBackButtonClicked = (event) => {
        setToggleProductEdit(false);
        setToggleInfoEdit(false);
    }

    const onDeleteButtonClicked = (event) => {

    }

    const onDateChanged = (event) => {

    }

    return (
        <Box sx={styles.container}>
            <Box sx={styles.searchContainer}>
                <Box sx={styles.adminHeader}>
                    <TextField
                        sx={styles.searchField}
                        placeholder="Search"
                        size='small'
                        InputProps={{
                            startAdornment: <InputAdornment position='start'><SearchIcon /></InputAdornment>
                        }}
                    />
                    <Button variant='contained' >Search</Button>
                    <Button variant='contained' sx={styles.addUserButton}><PersonAddAltIcon /></Button>
                </Box>
                <hr id="searchHR" />
                <Box sx={styles.resultsContainer}>
                    <Typography>7 Results</Typography>
                    <TableContainer component={Paper}>
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>User Email</TableCell>
                                    <TableCell>Account ID</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {nums.map((val, index) => (
                                    <TableRow key={index} sx={styles.tableRow} onClick={onTableRowClicked}>
                                        <TableCell>{val}</TableCell>
                                        <TableCell>{val}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </Box>
            <Box sx={styles.selectionContainer}>
                <Box sx={styles.leftInfoContainer}>
                    <Button variant='contained' onClick={onMainBackButtonClicked}>Back</Button>
                    <hr id='selectionHR' />
                    <Typography>User username's products</Typography>
                    <Box sx={styles.mediaContainer}>
                        {nums.map((val, arrayIndex) => {
                            return <AdminGalleryItem index={arrayIndex} key={arrayIndex} clickAction={onGalleryItemClicked} currentIndex={selectedIndex} />
                        })}
                    </Box>
                </Box>
                <Box sx={styles.rightSidebarContainer}>
                    <Box id="actionBar" sx={styles.actionBar} >
                        <Stack direction="row"  >
                            <IconButton sx={styles.backButton} onClick={onBackButtonClicked}>
                                <ArrowBackOutlinedIcon />
                            </IconButton>
                            <IconButton sx={styles.editButton} onClick={onEditButtonClicked}>
                                <EditOutlinedIcon />
                            </IconButton >
                            <IconButton onClick={onDeleteButtonClicked} sx={styles.deleteButton}>
                                <DeleteOutlineOutlinedIcon />
                            </IconButton>
                        </Stack>
                    </Box>
                    <Box sx={styles.userInfoContainer}>
                        <Typography>Username</Typography>
                        <Typography align='right'>fantasticguy@gmail.com</Typography>
                        <Typography>First Name</Typography>
                        <Typography align='right'>Harry</Typography>
                        <Typography>Last Name</Typography>
                        <Typography align='right'>Potter</Typography>
                        <Typography>Phone</Typography>
                        <Typography align='right'>1-800-Not-Here</Typography>
                        <Typography>Address</Typography>
                        <Typography align='right'>2442 Blueberry Lane</Typography>
                        <Typography>State</Typography>
                        <Typography align='right'>CA</Typography>
                        <Typography>Patreon</Typography>
                        <Typography align='right'>hpotter@patreon</Typography>
                        <Typography>Cashapp</Typography>
                        <Typography align='right'>$spellcaster26</Typography>
                        <Typography>Role</Typography>
                        <Typography align='right'>Admin</Typography>
                        <Typography>Title</Typography>
                        <Typography align='right'>Grandmaster</Typography>
                        <Typography sx={styles.biographyLabel}>Biography</Typography>
                        <Typography sx={styles.biographyText}>Loren ipsum something something description for this nv I want t
                            piece of work made by that guy from that place called edfo be the
                            by the name in the event of something lorem lorem alr e very best
                            ight lets end this</Typography>
                    </Box>
                    <Box sx={styles.userEditContainer}>
                        <Typography>User edit view</Typography>
                    </Box>
                    <Box sx={styles.userProductViewContainer}>
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
                    <Box sx={styles.userProductEditContainer}>

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
        </Box>
    )
}

export default AdminPanel