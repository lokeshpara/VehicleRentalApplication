# GitHub Deployment Guide

This guide will help you deploy your Vehicle Rental Application to GitHub.

## 📋 Prerequisites

1. **Git** installed on your system
   - Download from: https://git-scm.com/downloads
   - Verify installation: `git --version`

2. **GitHub Account**
   - Create account at: https://github.com
   - Verify email address

3. **GitHub Repository** (create an empty repository)
   - Go to: https://github.com/new
   - Repository name: `VehicleRentalApplication` (or your preferred name)
   - Description: "Vehicle Rental Management System - J2EE Application"
   - Choose Public or Private
   - **DO NOT** initialize with README, .gitignore, or license (we already have these)

## 🚀 Step-by-Step Deployment

### Step 1: Open Terminal/Command Prompt

Navigate to your project directory:
```bash
cd "C:\Users\Lokesh P\Downloads\ParaLokesh_VehicleRentApplication_FinalCaseStudy\ParaLokesh_VehicleRentApplication"
```

### Step 2: Initialize Git Repository

```bash
git init
```

This creates a new Git repository in your project folder.

### Step 3: Check Current Status

```bash
git status
```

This shows which files are untracked. You should see your source files listed.

### Step 4: Add Files to Staging Area

```bash
git add .
```

This adds all files (respecting .gitignore) to the staging area.

### Step 5: Create Initial Commit

```bash
git commit -m "Initial commit: Vehicle Rental Application with MVC framework"
```

### Step 6: Add GitHub Remote

Replace `YOUR_USERNAME` and `YOUR_REPO_NAME` with your actual values:

```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

**Example:**
```bash
git remote add origin https://github.com/lokeshp/VehicleRentalApplication.git
```

### Step 7: Rename Branch to Main (if needed)

```bash
git branch -M main
```

### Step 8: Push to GitHub

```bash
git push -u origin main
```

You'll be prompted for your GitHub credentials:
- **Username**: Your GitHub username
- **Password**: Use a Personal Access Token (not your GitHub password)

## 🔐 Creating a Personal Access Token

GitHub requires Personal Access Tokens for authentication:

1. Go to: https://github.com/settings/tokens
2. Click "Generate new token" → "Generate new token (classic)"
3. Give it a name: "Vehicle Rental App"
4. Select scopes: Check `repo` (full control of private repositories)
5. Click "Generate token"
6. **Copy the token immediately** (you won't see it again)
7. Use this token as your password when pushing

## ✅ Verify Deployment

1. Go to your GitHub repository URL
2. You should see all your files
3. Check that:
   - ✅ Source code is present
   - ✅ README.md is visible
   - ✅ .gitignore is present
   - ❌ Build files are NOT present (excluded by .gitignore)

## 🔄 Making Future Updates

After making changes to your code:

```bash
# Check what changed
git status

# Add changed files
git add .

# Commit changes
git commit -m "Description of your changes"

# Push to GitHub
git push
```

## 🛡️ Security Best Practices

### Before Pushing - Remove Sensitive Data

1. **Check `context.xml`**:
   ```bash
   # Open and review
   src/main/webapp/META-INF/context.xml
   ```
   
   If it contains real database credentials, either:
   - Remove the file and add it to .gitignore
   - Replace with placeholder values
   - Use environment variables

2. **Create Template File** (Optional):
   ```bash
   cp src/main/webapp/META-INF/context.xml src/main/webapp/META-INF/context.xml.template
   ```
   
   Then edit `context.xml` to use placeholders:
   ```xml
   username="YOUR_DB_USERNAME"
   password="YOUR_DB_PASSWORD"
   ```

3. **Update .gitignore** (if needed):
   Add this line if you want to exclude the actual config:
   ```
   src/main/webapp/META-INF/context.xml
   ```

## 📁 What Gets Pushed

✅ **Included:**
- All source code (`.java` files)
- JSP files
- CSS files
- Configuration files (web.xml, mvc.properties)
- README.md
- .gitignore

❌ **Excluded (via .gitignore):**
- Compiled classes (`.class` files)
- Build directory
- IDE-specific files (.idea, .settings, etc.)
- Log files
- Temporary files

## 🔧 Troubleshooting

### Issue: "remote origin already exists"
**Solution:**
```bash
git remote remove origin
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

### Issue: "Authentication failed"
**Solution:**
- Use Personal Access Token instead of password
- Check token has `repo` scope enabled

### Issue: "Permission denied"
**Solution:**
- Verify repository name is correct
- Check you have write access to the repository
- Ensure you're using the correct GitHub username

### Issue: "Large files warning"
**Solution:**
- Check if JAR files in `WEB-INF/lib` are being tracked
- They should be excluded, but if not, add to .gitignore:
  ```
  *.jar
  *.war
  ```

## 📝 Commit Message Best Practices

Use clear, descriptive commit messages:
- ✅ `"Add user registration functionality"`
- ✅ `"Fix booking cancellation bug"`
- ✅ `"Update README with deployment instructions"`
- ❌ `"update"`
- ❌ `"fix"`
- ❌ `"changes"`

## 🌿 Branching Strategy (Optional)

For larger projects, consider using branches:

```bash
# Create feature branch
git checkout -b feature/new-feature

# Make changes and commit
git add .
git commit -m "Add new feature"

# Push branch
git push -u origin feature/new-feature

# Merge to main (on GitHub or locally)
git checkout main
git merge feature/new-feature
```

## 📚 Additional Resources

- [Git Documentation](https://git-scm.com/doc)
- [GitHub Guides](https://guides.github.com/)
- [GitHub CLI](https://cli.github.com/) (alternative to web interface)

## 🎉 Success!

Once deployed, your repository will be accessible at:
```
https://github.com/YOUR_USERNAME/YOUR_REPO_NAME
```

Share this link with others to collaborate or showcase your work!

---

**Need Help?** Check GitHub's documentation or create an issue in your repository.

