# Quick Deployment Commands

Copy and paste these commands in your terminal (PowerShell or Command Prompt) to deploy to GitHub.

## 🚀 Quick Start Commands

### 1. Navigate to Project Directory
```bash
cd "C:\Users\Lokesh P\Downloads\ParaLokesh_VehicleRentApplication_FinalCaseStudy\ParaLokesh_VehicleRentApplication"
```

### 2. Initialize Git (First Time Only)
```bash
git init
```

### 3. Add All Files
```bash
git add .
```

### 4. Create Commit
```bash
git commit -m "Initial commit: Vehicle Rental Application"
```

### 5. Add Remote (Replace with your GitHub repo URL)
```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

### 6. Push to GitHub
```bash
git branch -M main
git push -u origin main
```

## 📝 Example with Real Values

Replace these placeholders:
- `YOUR_USERNAME` → Your GitHub username (e.g., `lokeshp`)
- `YOUR_REPO_NAME` → Your repository name (e.g., `VehicleRentalApplication`)

**Example:**
```bash
git remote add origin https://github.com/lokeshp/VehicleRentalApplication.git
git push -u origin main
```

## ⚠️ Before Pushing - Security Check

1. **Check context.xml for sensitive data:**
   ```bash
   # Review the file
   notepad src/main/webapp/META-INF/context.xml
   ```

2. **If it contains real passwords**, either:
   - Replace with placeholders before committing
   - Or add to .gitignore (already configured)

## ✅ Verify After Push

Visit your GitHub repository URL to confirm all files are uploaded.

---

**Note:** You'll need a Personal Access Token for authentication. See `GITHUB_DEPLOYMENT.md` for details.

