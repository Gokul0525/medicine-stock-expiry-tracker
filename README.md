# MediTrack — Medicine Stock & Expiry Tracker

A responsive browser-based demo designed for iPad, iPhone, and desktop browsers.

## Features
- Dashboard for medicine count, stock units, low stock, and expiry alerts
- Add, edit, and delete medicine records
- Increase or decrease stock quantities
- Search, filter, and sort inventory
- Low-stock, expiring-soon, and expired alerts
- Export inventory as CSV
- Saves data in the browser using `localStorage`

## Run locally
Open `index.html` in a modern browser. No Java, MySQL, server, or build tools are required.

## Publish with GitHub Pages
1. Sign in to GitHub and create a repository, e.g. `medicine-stock-expiry-tracker`.
2. Upload `index.html` to the repository's root folder. You can also upload this `README.md`.
3. Open **Settings → Pages** in the repository.
4. Under **Build and deployment**, choose **Deploy from a branch**.
5. Select branch **main** and folder **/ (root)**, then choose **Save**.
6. Wait for GitHub Pages to publish. The website URL will appear in the Pages section.

## Important data note
This is a front-end demo. Medicine records are stored only in the browser on the device where they are entered. They are not synced to GitHub or other devices, and clearing browser website data may erase them. Do not use this demo as the sole record system for a real pharmacy. A shared multi-user system needs a secure backend and database.
